package org.codefromhell.jgit.examples;

import org.eclipse.jgit.lib.Repository;

import java.io.File;
import java.io.IOException;

/**
 * Show hot to open an exisiting repository.
 */
public class OpenRepository {
    public static Repository openRepository(String repoPath) {
        Repository repo = null;
        try {
            repo = new Repository(new File(repoPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return repo;
    }
}
