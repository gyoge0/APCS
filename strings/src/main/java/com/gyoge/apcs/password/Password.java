// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.password;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Password {

    private String password;
    private boolean isValid;
    private String reason;

    public Password(String password) {
        this.password = password;
        this.validate();
    }

    public Password() {
        this.password = "Abc@123";
        this.validate();
    }

    public boolean isValid() {
        return isValid;
    }

    public String getInvalidReason() {
        return reason;
    }

    public void changePassword(String password) {
        this.password = password;
        validate();
    }

    private void validate() {
        this.isValid = false;

        if (this.password.length() < 5) {
            reason = "too short";
            return;
        } else if (this.password.length() > 17) {
            reason = "too long";
            return;
        }

        @SuppressWarnings("SimplifyStreamApiCallChains")
        List<Integer> chars = this.password.chars().boxed().collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        if (chars.stream().noneMatch(Character::isLowerCase)) {
            sb.append("no lower case letters, ");
        }
        if (chars.stream().noneMatch(Character::isUpperCase)) {
            sb.append("no upper case letters, ");
        }
        if (chars.stream().anyMatch(c -> c == ' ')) {
            sb.append("contains spaces, ");
        }
        if (chars.stream().noneMatch(Character::isDigit)) {
            sb.append("no digits, ");
        }
        if (chars.stream().allMatch(c -> Character.isLetterOrDigit(c) || c == ' ')) {
            sb.append("no special characters, ");
        }

        this.isValid = sb.length() == 0;
        if (!this.isValid) reason = sb.reverse().delete(0, 2).reverse().toString();
    }
}
