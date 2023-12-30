package org.gol.processor.neighbor;

import org.gol.Grid;

/**
 * Interface representing a neighbor processor.
 *
 * @author Pedro Bernaldez
 */
public interface NeighborProcessor {

    /**
     * This method is invoked in the game loop to process the neighbors
     * in the given {@link Grid}.
     *
     * @param grid the grid
     */
    void process(Grid grid);
}
