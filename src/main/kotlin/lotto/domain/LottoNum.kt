package lotto.domain

import lotto.domain.generator.Generator

class LottoNum(generator: Generator) {

    private val _value: Int = generator.generate()

    val value: Int
        get() = _value

}