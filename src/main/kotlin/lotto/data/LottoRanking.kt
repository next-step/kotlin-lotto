package lotto.data

enum class LottoRanking(val matchingNumberCnt: Int, val price: Int) {
    FirstPlace(6,2000000000),
    SecondPlace(5,1500000),
    ThirdPlace(4,50000),
    FourthPlace(3,5000),
    None(0,0);
}
