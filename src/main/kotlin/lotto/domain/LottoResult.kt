package lotto.domain

enum class LottoResult(val KRW: KRW) {
    NotWin(KRW(0)),
    FourthWin(KRW(5000)),
    ThirdWin(KRW(50000)),
    SecondWin(KRW(150000)),
    FirstWin(KRW(2000000000))
}
