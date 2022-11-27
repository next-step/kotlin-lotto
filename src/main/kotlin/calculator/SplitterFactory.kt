package calculator

class SplitterFactory {

    fun getSplitter(text: String): Splitter {
        if (CustomSplitter.containsSplitter(text)) {
            return CustomSplitter()
        }
        return DefaultSplitter()
    }
}
