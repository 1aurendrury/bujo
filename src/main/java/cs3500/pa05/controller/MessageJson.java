package cs3500.pa05.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * JSON format of this record:
 * <p>
 * <code>
 * {
 *   "name": "method name",
 *   "arguments": {}
 * }
 * </code>
 * </p>
 *
 * @param className the name of the class
 * @param arguments   the arguments passed along with the message formatted as a Json object
 */
public record MessageJson(
    @JsonProperty("class-name") String className,
    @JsonProperty("fields") JsonNode arguments) {
}