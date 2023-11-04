package lotto.domain

class PurchasePrice(price: String) {
    val price: Int = price.toInt()
    init {
        require(price.isNotBlank()) { "입력값이 없습니다." }
        require(price.toIntOrNull() != null) { "숫자를 입력해주세요." }
    }
}
