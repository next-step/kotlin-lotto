package org.bmsk.domain.model.random

interface RandomGenerator {
    fun generate(exceptionNumbers: List<Int>): Int
}
