package additionCalculator

import additionCalculator.model.Splitter
import additionCalculator.view.InputView
import additionCalculator.view.ResultView

fun main() {
    val expression =
        InputView.getExpression("숫자를 입력해주세요.\n기본 구분자는 쉼표(,) 와 콜론(:)입니다.\n사용자 지정 구분자는 //%s\\n 방식으로 지정 가능합니다.")
    val tokens = Splitter.split(expression)
    val result = StringAddCalculator().add(tokens)
    ResultView.showResult(result)
}
