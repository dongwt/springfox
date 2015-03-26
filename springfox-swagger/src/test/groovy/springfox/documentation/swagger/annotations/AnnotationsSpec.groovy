package springfox.documentation.swagger.annotations

import spock.lang.Specification
import springfox.documentation.spring.web.dummy.controllers.ConcreteController

import java.lang.reflect.AnnotatedElement

import static Annotations.*

class AnnotationsSpec extends Specification {

  def "ApiResponses annotations should be looked up through the entire inheritance hierarchy"() {
    given:
      AnnotatedElement annotatedElement = ConcreteController.getMethod("get")
    expect:
      findApiResponsesAnnotations(annotatedElement).isPresent()
  }

  def "Cannot instantiate the annotations helper"() {
    when:
      new Annotations()
    then:
      thrown(UnsupportedOperationException)
  }

}