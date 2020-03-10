package inter.utilities;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.ByteBuffer;

public class LambdaInvoke {

  public static void main(String[] args) throws IOException {

    InvokeRequest invokeRequest = new InvokeRequest()
      .withFunctionName("aws-java-simple-http-endpoint-dev-currentTime");

    BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAITF6EULYF2ZRECNQ", "BUXxKjgmfUBj+9i2HKZL9VABpQDmgI0PNIaQlmh9");

    AWSLambda awsLambda = AWSLambdaClientBuilder.standard()
      .withRegion(Regions.US_EAST_1)
      .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

    InvokeResult invokeResult = null;

    try {
      invokeResult = awsLambda.invoke(invokeRequest);
    }
    catch (Exception e) {

    }

    System.out.println(invokeResult.getStatusCode());

    ByteBuffer byteBuffer = invokeResult.getPayload();

    String rawJson = null;

    try {
      rawJson = new String(byteBuffer.array(), "UTF-8");
    }catch (Exception e) {

    }

    System.out.println(rawJson);

    ObjectMapper mapper = new ObjectMapper();

    try {
      Response response = mapper.readValue(rawJson, Response.class);
    } catch(Exception e) {

    }

  }
}