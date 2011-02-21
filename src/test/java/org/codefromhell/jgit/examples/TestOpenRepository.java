package org.codefromhell.jgit.examples;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.lib.Repository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;

/**
 * Run tests again {@link OpenRepository}.
 */
public class TestOpenRepository {

    private String repoPath = System.getProperty("java.io.tmpdir") + "/tempGitRepo";

    private Repository repo;

    @Before
    public void startUp() {
        repo = CreateRepository.createRepository(repoPath);
        repo.close();
    }

    @Test
    public void testOpenRepository() {
        Repository checkRepo = OpenRepository.openRepository(repoPath);
        assertFalse(checkRepo.getConfig().getAuthorEmail().isEmpty());
        checkRepo.close();        
    }

    @After
    public void cleanUp() {
        try {
            FileUtils.deleteDirectory(new File(repoPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
