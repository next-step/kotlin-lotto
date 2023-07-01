package stringaddcalculator.domain

class NumbersGenerator(private val input: String) {

    fun generate(): Numbers {
        return byDefaultDelimiters()
    }

    private fun byDefaultDelimiters() = input.split(DEFAULT_DELIMITER_REGEX)
        .map { it.trim() }
        .map { Number.of(it) }
        .let { Numbers(it) }

    companion object {
        private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()
    }
}
