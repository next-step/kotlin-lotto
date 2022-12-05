package stringPlusCalculator.exception
class CustomParserNotExistsException(message: String = "커스텀 구분자가 존재하지 않습니다.") : IllegalArgumentException(message)
