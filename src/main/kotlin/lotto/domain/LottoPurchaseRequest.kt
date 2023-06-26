package lotto.domain

/**
 * 1. 로또를 자동, 수동 몇 장 살지
 * 2. 수동을 산다면 무슨 번호로 살지 기입해서
 * 3. Seller에게 전달하는 객체
 */
data class LottoPurchaseRequest(
    val autoAmount: Int,
    val manualNumbers: List<List<Int>>
)
