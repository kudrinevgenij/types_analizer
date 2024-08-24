package ru.kudrinevgeniy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CLParserTest {
    @Test
    @DisplayName("Args is valid")
    public void whenAllIsNormal() {
        String[] args = new String[] {"-s", "-a", "-p", "test_", "input.txt"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.getInputFiles().get(0)).isEqualTo("input.txt");
    }

    @Test
    @DisplayName("Args contain the -a flag")
    public void whenFlagA() {
        String[] args = new String[] {"-a"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.isAddMode()).isTrue();
    }
    @Test
    @DisplayName("Args contain the -f flag")
    public void whenFlagF() {
        String[] args = new String[] {"-f"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.isFullStatistics()).isTrue();
    }

    @Test
    @DisplayName("Args contain the -p flag")
    public void whenFlagP() {
        String[] args = new String[] {"-p", "test_"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.hasPrefix()).isTrue();
    }

    @Test
    @DisplayName("Args contain the -p flag but no prefix")
    public void whenFlagPButNoPrefix() {
        String[] args = new String[] {"-p", "test.txt"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.hasPrefix()).isFalse();
    }

    @Test
    @DisplayName("Args no contains input files names")
    public void whenNoInputFiles() {
        String[] args = new String[] {"-s", "-a", "-p", "test_"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.isPassed).isFalse();
    }
}