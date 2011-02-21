package org.codefromhell.jgit.examples;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.lib.Repository;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Run tests again {@link org.codefromhell.jgit.examples.CreateRepository}.
 */
public class TestCreateRepository {

    private String repoPath = System.getProperty("java.io.tmpdir") + "/tempGitRepo";

    @Test
    public void testCreateRepository() {

        Repository repo = CreateRepository.createRepository(repoPath);

        System.out.println(repo.getConfig().getAuthorEmail());
        assertFalse(repo.getConfig().getAuthorEmail().isEmpty());
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
