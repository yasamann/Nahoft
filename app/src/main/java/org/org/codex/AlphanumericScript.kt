package org.org.codex

import java.util.*

class AlphanumericScript: Script {
    val alphabet: Array<String> = arrayOf(
        "۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹",
        "ی", "ک",
        "پ", "چ", "ژ", "گ",
        "ء", "أ", "ئ", "ؤ", "ا", "ب", "پ", "ت", "ث", "ج", "چ", "ح", "خ", "د",
        "ذ", "ر", "ز", "ژ", "س", "ش", "ص", "ض", "ط", "ظ", "ع", "غ", "ف", "ق",
        "ک", "گ", "ل", "م", "ن", "و", "ه", "ی"
    )

    override fun encode(bits: BitSet): String
    {
        var result: String = String()

        val one = 1.toBigInteger()
        val two = 2.toBigInteger()
        var integer = 0.toBigInteger()
        for (index in 0..bits.size())
        {
            val bit = bits.get(index)

            when (bit)
            {
                true -> integer = integer + one
            }

            integer = integer * two
        }

        integer = integer / two

        print(integer)

        val base = alphabet.size.toBigInteger()
        while (integer > base)
        {
            val digit = integer % base
            val symbol = alphabet[digit.toInt()]
            result = result + symbol

            integer = integer / base
        }

        return result
    }

    override fun decode(ciphertext: String): BitSet
    {
        var result = BitSet(0)

        val one = 1.toBigInteger()
        val two = 2.toBigInteger()
        val base = alphabet.size.toBigInteger()
        var integer = 0.toBigInteger()
        for (offset in 0..ciphertext.length-1)
        {
            val symbol = Character.toString(ciphertext[offset])
            var foundIndex = 0
            for (index in 0..alphabet.size)
            {
                if (alphabet[index] == symbol)
                {
                    foundIndex = index
                    break
                }
            }
            val digit = foundIndex.toBigInteger()

            integer = integer + digit

            integer = integer * base
        }

        integer = integer / base

        print(integer)

        var bitIndex = 0
        while (integer > one)
        {
            val bit = integer % two
            var bool: Boolean
            when (bit.toInt())
            {
                0 -> bool = false
                1 -> bool = true
            }

            result.set(bitIndex)
            bitIndex = bitIndex + 1

            integer = integer / two
        }

        return result
    }
}