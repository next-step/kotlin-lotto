package lotto.view

import lotto.view.enum.Message

class MessageView {

    fun getMessage(message: Message, vararg variables: String): String = formatMessage(message.message, *variables)

    private fun getVariableCount(message: String): Int = VARIABLE_PATTERN.findAll(message).count()

    private fun formatMessage(message: String, vararg variables: String): String {
        var formattedMessage: String = String(message.toCharArray())

        if (getVariableCount(message) != variables.size) {
            throw IllegalArgumentException(getMessage(Message.MISMATCHED_VARIABLE_COUNT))
        }

        variables.forEachIndexed { idx, variable -> formattedMessage = formattedMessage.replace("[$idx]", variable) }

        return formattedMessage
    }

    companion object {
        val VARIABLE_PATTERN: Regex = Regex("\\[\\d+\\]")
    }
}
