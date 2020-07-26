const axiosErrorHandler = (error) => {
  console.error(error);
  if (error.response) {
    return { errorMessage: `Ha ocurrido un error con la respuesta, status ${error.response.status}`};
  } else if (error.request) {
    return { errorMessage: 'Ha ocurrido un error en la petición'}; 
  } else {
    return { errorMessage: `Error: ${error}`}
  }
}

export { axiosErrorHandler };