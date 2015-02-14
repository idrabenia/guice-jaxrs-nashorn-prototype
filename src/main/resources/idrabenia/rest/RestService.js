var Response = javax.ws.rs.core.Response;
var ResponseEntry = Java.type('idrabenia.rest.SampleRESTWebService.ResponseEntry');

function listUsers(userDao) {
  userDao.findAll();
  userDao.findAllDetails();

  return Response
      .ok(
        new ResponseEntry(
          userDao.findAll_flat()
        )
      )
      .build();
}
