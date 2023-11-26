package lotto.view

enum class ResultType(val message: String) {
    PURCHASE_COUNT("%d개를 구매했습니다."),
    PROFIT_RATE("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"),
}
