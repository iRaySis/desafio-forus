import { request, externalRequest } from '../api';
import { axiosErrorHandler } from '../errorHandler';

const selectApi = (useExternal) => {
  if (useExternal) {
    return externalRequest;
  }
  return request;
}

const getProduct = async (useExternal = false, id = undefined) => {
  const api = selectApi(useExternal);
  return await api.get(`producto/${id? id : ''}`)
  .then(res => {
    if (res.status == 200) {
      return res.data;
    } else {
      throw new Error(`El status de la respuesta no fue el esperado, Status: ${res.status} `);
    }
  }).catch(err => axiosErrorHandler(err));
}

const deleteProduct = async (id, useExternal = false) => {
  const api = selectApi(useExternal);
  return await api.delete(`producto/${id}`)
  .then(res => {
    if (res.status == 200) {
      return res.data;
    } else {
      throw new Error(`El status de la respuesta no fue el esperado, Status: ${res.status} `);
    }
  }).catch(err => axiosErrorHandler(err));
}

const saveProduct = async (data, useExternal = false) => {
  const api = selectApi(useExternal);
  return await api.post('producto/', data)
  .then(res => {
    if (res.status == 201) {
      return res.data;
    } else {
      throw new Error(`El status de la respuesta no fue el esperado, Status: ${res.status} `);
    }
  }).catch(err => axiosErrorHandler(err));
}

const updateProduct = async (data, useExternal = false) => {
  const api = selectApi(useExternal);
  return await api.put('producto/', data)
  .then(res => {
    if (res.status == 200) {
      return res.data;
    } else {
      throw new Error(`El status de la respuesta no fue el esperado, Status: ${res.status} `);
    }
  }).catch(err => axiosErrorHandler(err));
}


export { getProduct, deleteProduct, saveProduct, updateProduct}