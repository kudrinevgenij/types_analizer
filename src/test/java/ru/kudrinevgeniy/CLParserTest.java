package ru.kudrinevgeniy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CLParserTest {
    @Test
    public void whenAllIsNormal() {
        String[] args = new String[] {"-s", "-a", "-p", "test_", "input.txt"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.inputFiles.get(0)).isEqualTo("input.txt");
    }

}