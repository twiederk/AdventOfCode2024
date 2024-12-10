import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Path

class Day09Test {

    @Test
    fun should_load_data() {
        // arrange

        // act
        val data = Day09().loadData(Path.of("src", "test", "resources", "Day09_TestData.txt"))

        // assert
        assertThat(data).isEqualTo("2333133121414131402")

    }

    @Test
    fun should_calculate_checksum() {

        // act
        val checksum = Day09().checksum("0099811188827773336446555566..............")

        // assert
        assertThat(checksum).isEqualTo(1928)
    }

    @Test
    fun should_create_empty_filesystem() {

        // act
        val fileSystem = Day09().createFileSystem(20_000)

        // assert
        assertThat(fileSystem.length).isEqualTo(20_000)
    }

    @Test
    fun should_create_fileBlocks() {
        // arrange
        val fileSystem = "12345"

        // act
        val fileBlocks = Day09().createFileBlocks(fileSystem)

        // assert
        assertThat(fileBlocks).containsExactly(
            FileBlock(0, '1', 1),
            FileBlock(1, '.', 2),
            FileBlock(2, '3', 3),
            FileBlock(3, '.', 4),
            FileBlock(4, '5', 5)
        )
    }

    @Test
    fun should_print_file_blocks() {
        // arrange
        val fileBlocks = listOf(
            FileBlock(0, '1', 1),
            FileBlock(1, '.', 2),
            FileBlock(2, '3', 3),
            FileBlock(3, '.', 4),
            FileBlock(4, '5', 5)
        )

        // act
        val result = Day09().printFileBlocks(fileBlocks)

        // assert
        assertThat(result).isEqualTo("0..111....22222")
    }
}

private fun Day09.printFileBlocks(fileBlocks: List<FileBlock>): String {
    var pointer = 0
    val fileSystem = StringBuilder()
    fileBlocks.forEach { fileBlock ->
        fileSystem.append(".".repeat(fileBlock.size))
        fileSystem.replace(pointer, pointer + 1, fileBlock.id.toString())
        pointer += fileBlock.size
    }

    return String(fileSystem)
}

