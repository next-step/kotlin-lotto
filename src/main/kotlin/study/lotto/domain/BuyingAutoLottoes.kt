package study.lotto.domain

class BuyingAutoLottoes(val lottoes: Lottoes) : List<Lotto> by lottoes
