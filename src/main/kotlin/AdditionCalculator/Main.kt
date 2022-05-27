package AdditionCalculator

import AdditionCalculator.model.Splitter
import AdditionCalculator.view.InputView
import AdditionCalculator.view.ResultView

fun main() {
  val expression = InputView.getExpression("숫자를 입력해주세요.\n기본 구분자는 쉼표(,) 와 콜론(:)입니다.\n사용자 지정 구분자는 //%s\\n 방식으로 지정 가능합니다.")
  if (expression.isNullOrBlank()) {
    return ResultView.showResult(0)
  }

  val splitter = Splitter(expression)
  val result = StringAddCalculator().add(splitter.tokens)
  ResultView.showResult(result)
}
