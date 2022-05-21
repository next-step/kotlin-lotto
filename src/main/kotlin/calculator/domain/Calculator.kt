package calculator.domain

/**
 * 계산을 하는 클래스.
 * Created by Jaesungchi on 2022.05.21..
 */
object Calculator {
    fun getResultOfCalculate(input: String?): Int {
        // 빈 문장 또는 null이 입력되면 0을 반환 한다.
        if (input.isNullOrBlank()) {
            return 0
        }
        return 0 // TODO output값으로 변경해야함.
    }
}
