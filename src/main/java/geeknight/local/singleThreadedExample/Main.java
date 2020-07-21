package geeknight.local.singleThreadedExample;


import geeknight.model.Block;
import geeknight.model.BlockChain;
import geeknight.model.BlockValidationException;
import geeknight.model.HashResult;
import geeknight.local.utils.BlockChainUtils;
import geeknight.local.utils.BlocksData;

public class Main {

    public static void main(String[] args) throws BlockValidationException {

        int difficultyLevel = 5;

        Long start = System.currentTimeMillis();
        BlockChain blocks = new BlockChain();

        String lastHash = "0";
        for (int i = 0; i < 10; i++) {

            Block nextBlock = BlocksData.getNextBlock(i, lastHash);
            HashResult hashResult = BlockChainUtils.mineBlock(nextBlock, difficultyLevel, 0, 100000000);
            if (hashResult == null) {
                throw new RuntimeException("Didn't find a valid hash for block " + i);
            }

            nextBlock.setHash(hashResult.getHash());
            nextBlock.setNonce(hashResult.getNonce());
            blocks.addBlock(nextBlock);
            System.out.println("Block " + i + " hash : " + nextBlock.getHash());
            System.out.println("Block " + i + " nonce: " + nextBlock.getNonce());
            lastHash = nextBlock.getHash();
        }

        Long end = System.currentTimeMillis();
        blocks.printAndValidate();

        System.out.println("Time taken " + (end - start) + " ms.");
    }
}
