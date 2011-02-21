package org.codefromhell.jgit.examples;

import org.eclipse.jgit.lib.Repository;

import java.io.File;
import java.io.IOException;

/**
 * Show how to create a new local repository.
 */
public class CreateRepository {
    public static Repository createRepository(String repoPath) {
        Repository repo = null;
        try {
            repo = new Repository(new File(repoPath));
            repo.create();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return repo;
    }
}
