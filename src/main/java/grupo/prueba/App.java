package grupo.prueba;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main( String[] args )
    {
        //setLogLevel(Level.INFO);
        LOGGER.trace("Log level trace");
        LOGGER.debug("Log level debug");
        LOGGER.info("Log level info");
        LOGGER.warn("Log level warn");
        LOGGER.error("Log level error");
        LOGGER.fatal("Log level fatal");
    }

    /**
     * Credit: http://stackoverflow.com/a/18409096/1612432
     *
     * @param l The log level to set
     */
    /*
    public static void setLogLevel(Level l) {
        LOGGER.info("Setting log level to " + l.name());
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration conf = ctx.getConfiguration();
        conf.getLoggerConfig(LogManager.ROOT_LOGGER_NAME).setLevel(l);
        ctx.updateLoggers(conf);
    }
    */
}
