package next.step.lotto.domain

object LottoNumberParser {
    
    fun parse(str: String): Set<LottoNumber> = str.split(",")
        .map { LottoNumber.of(it.trim().toInt()) }
        .toSet()
}