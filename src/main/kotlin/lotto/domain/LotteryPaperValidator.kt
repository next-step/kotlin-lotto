package lotto.domain

class LotteryPaperValidator {
    fun validateDuplicateLotteryPaper(lotteryPaperList: List<LotteryPaper>) {
        require(lotteryPaperList.toSet().size == lotteryPaperList.size) {
            "중복된 로또 용지가 존재합니다. 입력값을 다시 확인하세요."
        }
    }

    fun validateIsAlreadyExistLotteryPaper(lotteryPaperList: List<LotteryPaper>, generatedLotteryPaper: LotteryPaper) {
        require(!lotteryPaperList.contains(generatedLotteryPaper)) {
            "이미 존재하는 로또 용지입니다. 다시 생성하세요."
        }
    }
}
