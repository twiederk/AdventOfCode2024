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

    fun fragmenter(fileSystem: MutableList<Int>): List<Int> {
        var leftPointer = 0
        var rightPointer = fileSystem.size - 1
        while (leftPointer < rightPointer) {
            if (fileSystem[leftPointer] == FREE) {
                // swap
                val temp = fileSystem[leftPointer]
                fileSystem[leftPointer] = fileSystem[rightPointer]
                fileSystem[rightPointer] = temp
                rightPointer--
                while (fileSystem[rightPointer] == FREE) {
                    rightPointer--
                }
            }
            leftPointer++
        }
        return fileSystem
    }

    fun checksum(filesystem: List<Int>): Long {
        return filesystem.withIndex()
            .filter { it.value != FREE }
            .sumOf { it.index * it.value.toLong() }
    }

    fun solvePart1(diskMap: String): Long {
        val filesystem = filesystem(diskMap)
        val newFilesystem = fragmenter(filesystem.toMutableList())
        return checksum(newFilesystem)
    }

    fun freeSpace(fileSystem: List<Int>, fileSize: Int, end: Int): Int {
        for (index in 0..<end) {
            if (fileSystem.subList(index, index + fileSize).all { it == FREE }) {
                return index
            }
        }
        return -2
    }

    companion object {
        const val FREE = -1
        const val NO_FREE_SPACE = -2
    }

}

fun main() {
    val day09 = Day09()
    val diskMap = day09.loadData(Path.of("src", "main", "resources", "Day09_InputData.txt"))
    val checksum = day09.solvePart1(diskMap)
    println("part1: $checksum")
}