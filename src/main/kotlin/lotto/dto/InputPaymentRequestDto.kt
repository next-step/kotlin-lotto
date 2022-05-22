package lotto.dto

data class InputPaymentRequestDto(
    val payment: Int
) {

    companion object {
        fun convertInt(inputPayment: String): InputPaymentRequestDto {
            val payment: Int = inputPayment.toIntOrNull() ?: throw IllegalArgumentException(CANNOT_CONVERT_INT)
            return InputPaymentRequestDto(payment)
        }

        const val CANNOT_CONVERT_INT = "정수로 변환할 수 업습니다."
    }
}
