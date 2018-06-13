import org.apache.maven.model.Build;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

/**
 * @goal buildinfo
 * @phase  pre-integration-test
 */
public class BuildInfoMojo extends AbstractMojo {

    /**
     * @parameter expression="${project}"
     * @readonly
     */
    private MavenProject mavenProject;

    /**
     * @parameter expression="${buildinfo.prefix}"
     * default-value="+++"
     */
    private String prefix;

    public void execute() throws MojoExecutionException, MojoFailureException {
        Build build = mavenProject.getBuild();
        String outputDirectory = build.getOutputDirectory();
        String sourceDirectory = build.getSourceDirectory();
        String testOutputDirectory = build.getTestOutputDirectory();
        String testSourceDirectory = build.getTestSourceDirectory();
        getLog().info("\n==============\n Project build info.");

        String[] info = {outputDirectory, sourceDirectory, testOutputDirectory, testSourceDirectory};
        for(String item: info){
            getLog().info("\t"  + "   " + item);
        }
        getLog().info("=============");
    }
}
