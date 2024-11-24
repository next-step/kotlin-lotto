package lotto

class InvalidLottoNumberException(numbers: List<Int>) : RuntimeException("로또 번호는 1~45 까지의 값이어야 합니다. 현재 입력 = $numbers")
