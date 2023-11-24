package org.bmsk.domain.model.lotto

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { "$number 로또 번호의 범위를 벗어남" }
    }
}
