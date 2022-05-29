package lotto.dto

import lotto.domain.LottoNumber
import lotto.vo.Money

data class LottoBuyingRequest(
    val amount: Money,
    val manualCount: Int,
    val manualNumbers: List<List<LottoNumber>>,
) {
    init {
        require(manualCount == manualNumbers.size) {
            "수동 로또 구매가 잘못 되었습니다."
        }
    }
}
