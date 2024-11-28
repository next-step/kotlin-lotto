package lotto.domain

class LottoStringParser {

    fun parse(lottoStr: String): Lotto {
        return Lotto(
            lottoStr.split(",").map { it.trim().toIntOrNull().validate() },
        )
    }

    private fun Int?.validate(): Int {
        return this?.takeIf { it in LottoGenerator.RANGE }
            ?: throw IllegalArgumentException("로또 숫자의 범위는 ${LottoGenerator.RANGE} 입니다")
    }

}
