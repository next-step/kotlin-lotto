package lotto.dto

import java.math.BigDecimal

data class LottoBuyingRequest(
    val amount: BigDecimal,
    val manualCount: Int,
    val manualNumbers: List<String>
) {
    init {
        require(manualCount == manualNumbers.size) {
            "수동 로또 구매가 잘못 되었습니다."
        }
    }
}
