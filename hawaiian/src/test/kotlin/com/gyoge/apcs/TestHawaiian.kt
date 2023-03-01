package com.gyoge.apcs

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


@Suppress("TestFunctionName", "SpellCheckingInspection")
class TestHawaiian {
    @Test
    fun `Humuhumunukunukuapua'a`() {
        val phonetic = HawaiianPhonetics.generatePhonetic("Humuhumunukunukuapua'a")
        assertEquals("Hoo-moo-hoo-moo-noo-koo-noo-koo-ah-poo-ah'ah", phonetic)
    }

    @Test
    fun aloha() {
        val phonetic = HawaiianPhonetics.generatePhonetic("aloha")
        assertEquals("Ah-loh-hah", phonetic)
    }

    @Test
    fun Kakahiaka() {
        val phonetic = HawaiianPhonetics.generatePhonetic("Kakahiaka")
        assertEquals("Kah-kah-hee-ah-kah", phonetic)
    }

    @Test
    fun Mahalo() {
        val phonetic = HawaiianPhonetics.generatePhonetic("Mahalo")
        assertEquals("Mah-hah-loh", phonetic)
    }

    @Test
    fun `E komo mai`() {
        val phonetic = HawaiianPhonetics.generatePhonetic("E komo mai")
        assertEquals("Eh koh-moh meye", phonetic)
    }

    @Test
    fun maui() {
        val phonetic = HawaiianPhonetics.generatePhonetic("maui")
        assertEquals("Mow-ee", phonetic)
    }

    @Test
    fun kane() {
        val phonetic = HawaiianPhonetics.generatePhonetic("kane")
        assertEquals("Kah-neh", phonetic)
    }


    @Test
    fun Awiwewuw() {
        val phonetic = HawaiianPhonetics.generatePhonetic("Awiwewuw")
        assertEquals("Ah-wee-veh-voo-w", phonetic)
    }

    @Test
    fun Hoaloha() {
        val phonetic = HawaiianPhonetics.generatePhonetic("Hoaloha")
        assertEquals("Hoh-ah-loh-hah", phonetic)
    }


    @Test
    fun Keiki() {
        val phonetic = HawaiianPhonetics.generatePhonetic("Keiki")
        assertEquals("Kay-kee", phonetic)
    }

    @Test
    fun Huaai() {
        val phonetic = HawaiianPhonetics.generatePhonetic("Huaai")
        assertEquals("Hoo-ah-eye", phonetic)
    }


    @Test
    fun Kaiapuni() {
        val phonetic = HawaiianPhonetics.generatePhonetic("Kaiapuni")
        assertEquals("Keye-ah-poo-nee", phonetic)
    }

}