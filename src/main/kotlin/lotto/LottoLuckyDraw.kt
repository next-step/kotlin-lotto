package lotto

class LottoLuckyDraw(
    luckyNumberString: String
) {
    val luckyNumber = luckyNumberString.replace(" ", "").split(",").map { it.toInt() }
}