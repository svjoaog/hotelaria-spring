import { useEffect, useState } from "react";
import api from "../api/axios";
import { type Setor } from "../types/Setor";

interface Props{
    setorSelecionado: Setor | null;
    onSuccess: () => void
}

export function SetorForm({setorSelecionado, onSuccess}: Props){
    const [name, setName] = useState("");

    useEffect(() => {
        if(setorSelecionado){
            setName(setorSelecionado.name);
        } else{
            setName("");
        }
    }, [setorSelecionado]);

    function salvar(e: React.FormEvent){
        e.preventDefault();

        if(setorSelecionado?.id){
            api.put(`/setores/${setorSelecionado.id}`, {name})
                .then(onSuccess);
        } else{
            api.post("/setores", {name})
                .then(onSuccess);
        }
    }

    return(
        <form onSubmit={salvar}>
            <input 
                value={name}
                onChange={e => setName(e.target.value)}
                placeholder="Nome do Setor"
                required
            />
            <button type="submit">
                {setorSelecionado ? "Atualizar" : "Cadastrar"}
            </button>
        </form>
    )
}