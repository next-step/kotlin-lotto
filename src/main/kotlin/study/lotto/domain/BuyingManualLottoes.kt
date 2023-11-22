package study.lotto.domain

class BuyingManualLottoes(val lottoes: Lottoes) : List<Lotto> by lottoes
