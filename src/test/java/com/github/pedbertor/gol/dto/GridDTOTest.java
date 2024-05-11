package com.github.pedbertor.gol.dto;

import com.github.pedbertor.gol.gui.GUI;
import com.github.pedbertor.gol.gui.component.panel.GridPanel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link GridDTO}.
 *
 * @author Pedro Bernaldez
 */
public class GridDTOTest {

    private static final List<CellDTO> ALIVE_CELLS = List.of(
            new CellDTO(2, 1),
            new CellDTO(2, 2),
            new CellDTO(2, 3)
    );

    private final GridPanel gridPanel = createTestGridPanel();

    @Test
    public void checkFromGridPanel() {
        GridDTO gridDTOFromGridPanel = GridDTO.fromGridPanel(gridPanel);
        assertEquals(GUI.GRID_HEIGHT, gridDTOFromGridPanel.getHeight());
        assertEquals(GUI.GRID_WIDTH, gridDTOFromGridPanel.getWidth());
        List<CellDTO> aliveCells = gridDTOFromGridPanel.getAliveCells().stream().toList();
        assertEquals(ALIVE_CELLS.size(), aliveCells.size());
        for (CellDTO aliveCell : aliveCells) {
            assertTrue(ALIVE_CELLS.contains(aliveCell));
        }
    }

    private GridPanel createTestGridPanel() {
        GridPanel testGridPanel = new GridPanel();
        for (CellDTO aliveCell : ALIVE_CELLS) {
            testGridPanel.getCellButton(
                    aliveCell.getVerticalPosition(),
                    aliveCell.getHorizontalPosition()
            ).switchState();
        }
        return testGridPanel;
    }
}
