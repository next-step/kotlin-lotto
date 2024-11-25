package lotto

class BonusNumber(
    value: String?,
) {
    val value: LottoNumber = LottoNumber(value!!.toInt())
}