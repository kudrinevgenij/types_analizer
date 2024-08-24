package ru.kudrinevgeniy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CLParserTest {
    @Test
    @DisplayName("Args is valid")
    public void whenAllIsNormal() {
        String[] args = new String[] {"-s", "-a", "-p", "test_", "input.txt"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.getInputFiles()).isEqualTo(List.of("input.txt"));
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
        assertThat(parser.isFullStatistic()).isTrue();
    }

    @Test
    @DisplayName("Args contain the -p flag")
    public void whenFlagP() {
        String[] args = new String[] {"-p", "test_"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.hasPrefix()).isTrue();
        assertThat(parser.getPrefix()).isEqualTo("test_");
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
    @DisplayName("Args contain the -o flag")
    public void whenFlagO() {
        String[] args = new String[]{"-o", "/some/path"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.hasResultPath()).isTrue();
        assertThat(parser.getResultPath()).isEqualTo("/some/path");
    }

    @Test
    @DisplayName("Args contain the -s flag")
    public void whenFlagS() {
        String[] args = new String[]{"-s"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.isShortStatistic()).isTrue();
    }

    @Test
    public void whenNoInputFiles() {
        String[] args = new String[]{"-s", "-a", "-p", "test_"};
        CLParser parser = new CLParser(args);
        assertThat(parser.parse(), is(false));
        assertThat(parser.description(), equalTo(List.of("Don't contains input files.")));
    }

    @Test
    public void whenNonArgs() {
        CLParser parser = new CLParser(new String[]{});
        assertThat(parser.parse(), is(false));
        assertThat(parser.description(), equalTo(List.of(
                "Don't config statistic flags -s of -f.",
                "Don't contains input files."
        )));
    }

    @Test
    public void whenNonArgsStatistic() {
        CLParser parser = new CLParser(new String[]{"in1.txt"});
        assertThat(parser.parse(), is(false));
        assertThat(parser.description(), equalTo(List.of("Don't config statistic flags -s of -f.")));
    }
}
