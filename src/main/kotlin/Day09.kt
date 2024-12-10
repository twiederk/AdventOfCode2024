import java.nio.file.Path


class Day09 {

    fun loadData(path: Path): String {
        return Resources.resourceAsText(path.fileName.toString())
    }

    fun filesystem(diskMap: String): List<Int> {
        val filesystem = mutableListOf<Int>()
        diskMap.forEachIndexed { index, char ->
            if (index % 2 == 0) {
                // file
                val fileSize = char.digitToInt()
                val fileId = index / 2
                repeat(fileSize) {
                    filesystem.add(fileId)
                }
            } else {
                // empty space
                val fileSize = char.digitToInt()
                repeat(fileSize) {
                    filesystem.add(FREE)
                }
            }
        }
        return filesystem
    }

    companion object {
        const val FREE = -1
    }

}

