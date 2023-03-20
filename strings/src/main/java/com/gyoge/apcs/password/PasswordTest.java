// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.password;

/**
 * Tester file used in the lab
 */
@SuppressWarnings("SpellCheckingInspection")
class PasswordTest {

    public static void testPassword(String str) {
        Password pswd;
        if (str == null) {
            pswd = new Password();
            str = "default password";
        } else pswd = new Password(str);

        if (pswd.isValid()) {
            System.out.printf("%s is valid%n", str);
        } else {
            System.out.printf("%s is not valid, reason: %s%n", str, pswd.getInvalidReason());
        }
    }

    public static void testChangePassword(String olds, String news) {
        Password pswd;

        if (olds == null) {
            pswd = new Password();
            olds = "default password";
        } else pswd = new Password(olds);

        if (!pswd.isValid()) {
            System.out.printf("%s is not valid, reason: %s%n", olds, pswd.getInvalidReason());
        } else {
            System.out.printf("%s is valid%n", olds);
        }

        if (news == null) {
            pswd.changePassword("default password");
            news = "default password";
        } else pswd.changePassword(news);

        if (pswd.isValid()) {
            System.out.printf("%s is valid%n", news);
        } else {
            System.out.printf("%s is not valid, reason: %s%n", news, pswd.getInvalidReason());
        }
    }

    public static void main(String[] args) {
        testPassword(null);
        testPassword("heyThere1234!!");
        testPassword("heyT");
        testPassword("heyThere1234ab&*^%");
        testPassword("heyThere Fred");
        testPassword("heyThere");
        testPassword("heythere1234");
        testPassword("heyThere1234");
        testPassword(".. .. ..");

        testChangePassword("heyThere1234!!", "heyT");
        testChangePassword("heyT", "heyThere1234ab&*^%");
        testChangePassword("heyThere1234ab&*^%", "heyThere Fred");
        testChangePassword("heyThere Fred", "heyThere");
        testChangePassword("heyThere", "heythere1234");
        testChangePassword("heythere1234", "heyThere1234");
        testChangePassword("heyThere1234", ".. .. ..");
        testChangePassword(".. .. ..", null);
    }
}
