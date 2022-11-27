package lotto.domain

enum class CompareResult(value: Value) {
    NotWin(Value(0)),
    FourthWin(Value(5000)),
    ThirdWin(Value(50000)),
    SecondWin(Value(150000)),
    FirstWin(Value(2000000000))
}
