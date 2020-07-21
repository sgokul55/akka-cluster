package geeknight.local.utils;

import geeknight.model.Block;
import geeknight.model.Transaction;

import java.time.Instant;

public class BlocksData {

    private static int[] customerIds = {1732, 1650, 2209, 4545, 324, 1944, 6565, 1805, 1765, 7001};
    private static double[] amounts = {103.27, 66.54, -21.09, 44.65, 177.99, 189.02, 17.00, 32.99, 60.00, -10.00};

    public static Block getNextBlock(int id, String lastHash) {

        Transaction transaction = new Transaction(id, Instant.now().toEpochMilli(), customerIds[id], amounts[id]);
        Block nextBlock = new Block(transaction, lastHash);
        return nextBlock;
    }


}
