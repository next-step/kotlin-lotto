package lotto.view

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class BuyLottoInputViewTest : DescribeSpec({
    it("금액 입력을 위한 View String 을 내보낸다") {
        // then
        BuyLottoInputView.showUserMoneyInputGuide() shouldBe "구입금액을 입력해 주세요."
    }

    it("당첨 번호 입력을 위한 View String 을 내보낸다") {
        // then
        BuyLottoInputView.showWinningLottoNumbersInputGuide() shouldBe "지난 주 당첨 번호를 입력해 주세요."
    }
})
